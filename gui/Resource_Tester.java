//package gui;
//
//import java.awt.Color;
//import java.util.Date;
//
//
//import game.ScoreEntry;
//import game.goals.ConquerGoal;
//import game.players.Human;
//
//public class Resource_Tester {
//	public static void main(String[] args) {
//		Resources instant = Resources.getInstance();
//		ConquerGoal type = new ConquerGoal();
//		Color clr = new Color(255);
//		Human newPlayer = new Human("Hans", clr);
//		ScoreEntry entry1 = new ScoreEntry(newPlayer, type);
//		instant.addScoreEntry(entry1);
//		newPlayer.addPoints(100);
//		entry1 = new ScoreEntry(newPlayer, type);
//		instant.addScoreEntry(entry1);
//		newPlayer.addPoints(200);
//		entry1 = new ScoreEntry(newPlayer, type);
//		instant.addScoreEntry(entry1);
//		Human newPlayer2 = new Human("Peter", clr);
//		ScoreEntry entry2 = new ScoreEntry(newPlayer2, type);
//		instant.addScoreEntry(entry2);
//		instant.save(); // saving highscores;
//		ScoreEntry test = ScoreEntry.read("Hans;2;ad;q");
//		System.out.println(test.toString());
//	}

