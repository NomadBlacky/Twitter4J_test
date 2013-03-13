import java.util.Scanner;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


public class Twitter4J_test {
	
	private static Scanner scan = new Scanner(System.in);
	
	public void tweetMode() throws TwitterException {
		
		System.out.println("<< Tweet mode >>");
		
		String tweet = "";
		
		while (true) {
			
			System.out.print("TWEET: ");
			tweet = scan.nextLine();
			
			if(tweet.isEmpty()) {
				continue;
			}
			
			if(tweet.equals("exit")) {
				return;
			}
			
			if(tweet.length() > 140) {
				System.out.println("ツイートは140文字までです。");
				tweet = "";
				continue;
			}
			
			System.out.print("この内容でTweetしますか？(y/n) : ");

			if(scan.nextLine().equals("y")) {
				break;
			}

			return;
		}
		
		Twitter twitter = new TwitterFactory().getInstance();
		Status status = twitter.updateStatus(tweet);
		System.out.println(status.getUser().getName() + " として投稿しました。");
		
		//scan.close();		
	}

	/**
	 * @param args
	 * @throws TwitterException 
	 */
	public static void main(String[] args) throws TwitterException {

		Twitter4J_test THIS = new Twitter4J_test();
		scan = new Scanner(System.in);
		String mode = "";
		
		while (!mode.equals("exit")) {
			
			System.out.print("Select mode: ");
			mode = scan.nextLine();
			
			if(mode.equals("tweet")) {
				THIS.tweetMode();
			}
			
			//
		}
		
		scan.close();
	}
}
