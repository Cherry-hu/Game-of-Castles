package game.map;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Diese Klasse teilt Burgen in Königreiche auf
 */
public class Clustering {

    private Random random;
    private final List<Castle> allCastles;
    private final int kingdomCount;

    /**
     * Ein neues Clustering-Objekt erzeugen.
     * @param castles Die Liste von Burgen, die aufgeteilt werden sollen
     * @param kingdomCount Die Anzahl von Königreichen die generiert werden sollen
     */
    public Clustering(List<Castle> castles, int kingdomCount) {
        if (kingdomCount < 2)
            throw new IllegalArgumentException("Ungültige Anzahl an Königreichen");

        this.random = new Random();
        this.kingdomCount = kingdomCount;
        this.allCastles = Collections.unmodifiableList(castles);
    }

    /**Ordnen
     * Gibt eine Liste von Königreichen zurück.
     * Jedes Königreich sollte dabei einen Index im Bereich 0-5 bekommen, damit die Burg richtig angezeigt werden kann.
     * Siehe auch {@link Kingdom#getType()}
     */
    public List<Kingdom> getPointsClusters() {
    	// 1. Create kingdoms and spread them randomly
    	ArrayList<Kingdom> kingdoms = new ArrayList<Kingdom>();
    	for(int i = 0; i < kingdomCount; i++) {
    		Kingdom tmpK = new Kingdom(i); //setting id
    		tmpK.setCentre(new Point(random.nextInt(500), random.nextInt(500)));
    		int k = 0;
			while (kingdoms.size() != k) { // dont put two kingdom centres on the same position
				if(kingdoms.get(k).getCentre() == tmpK.getCentre()) {
					tmpK.setCentre(new Point(random.nextInt(500), random.nextInt(500)));
					k = 0;
				}
				k++;}
			kingdoms.add(tmpK);
    		}
       	// 2. Allocate castles
    	boolean assignmentOccured = true;
    	while(assignmentOccured == true) {
    		assignmentOccured = false;
    		Kingdom tmpK = kingdoms.get(0);

    		Double distance = 0.0;
	    	for(int c = 0; c < allCastles.size(); c++) {
	    		int currentK = 0; // element number of kingdom
	    		if(allCastles.get(c).getKingdom() != null) { // set current Castle
	    			for(Kingdom king: kingdoms) {
	    				if(king == allCastles.get(c).getKingdom()) {
	    					break;
	    				}
	    				currentK ++;
	    				tmpK = kingdoms.get(currentK);
	    			}
	    		}
	    		else if(allCastles.get(c).getKingdom() == null) {	// set first time castle to kingdom for beginning comparison
	    			distance = Math.sqrt(Math.pow(tmpK.getCentre().getX() - allCastles.get(c).getLocationOnMap().getX(), 2 ) + 
							Math.pow(tmpK.getCentre().getY() - allCastles.get(c).getLocationOnMap().getX(), 2));
					currentK = 0;
					allCastles.get(c).setKingdom(kingdoms.get(0));
				}
	    		for(int i = 0; i < kingdomCount; i++) {			
					tmpK = kingdoms.get(i);	
	    			Double tmpDistance = Math.sqrt( Math.pow(tmpK.getCentre().getX() - allCastles.get(c).getLocationOnMap().getX(), 2 ) + 
								Math.pow(tmpK.getCentre().getY() - allCastles.get(c).getLocationOnMap().getX(), 2) );
						if(tmpDistance < distance) {
							distance = tmpDistance;
							currentK = i;
						}
				}
	    		if(allCastles.get(c).getKingdom().getType() != kingdoms.get(currentK).getType() ) {
	    			allCastles.get(c).getKingdom().removeCastle(allCastles.get(c));
		    		allCastles.get(c).setKingdom(kingdoms.get(currentK));
	    			
	    			assignmentOccured = true;
	    		}
	    	}
	    	// 3. Set new Kingdom centres
	    	for(int i = 0; i < kingdomCount; i++) {
	    		double posX = 0;
	    		double posY = 0;
	    		List<Castle> tmpCastles = kingdoms.get(i).getCastles();
	    		for (Castle castle: tmpCastles) {
	    			posX = posX + castle.getLocationOnMap().x;
	    			posY = posY + castle.getLocationOnMap().y;
	    		}
	    		posX = posX / tmpCastles.size();
	    		posY = posY / tmpCastles.size();
	    		kingdoms.get(i).setCentre(new Point((int) posX, (int )posY));
	    	}
    	}
    	return kingdoms;
    }
}
