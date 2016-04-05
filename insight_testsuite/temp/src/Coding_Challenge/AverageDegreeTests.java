package Coding_Challenge;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AverageDegreeTests {

	
	@Test
	public void test2DistinctTweets() {
		Average_Degree ad = new Average_Degree();
		String file_input_path = "tests/test-2-tweets-all-distinct/tweet_input/tweets.txt";
		String file_output_path="tests/test-2-tweets-all-distinct/tweet_output/output.txt";
		String output = "1.00 2.33 ";
		assertEquals(output,ad.testInputOutputs(file_input_path,file_output_path));
	}
	

	@Test
        public void testNormalInsertion() {
                Average_Degree ad1 = new Average_Degree();                
		String file_input_path = "tests/test-normal-insertion/tweet_input/tweets.txt";
                String file_output_path="tests/test-normal-insertion/tweet_output/output.txt";
                String output = "2.00 2.00 2.00 2.50 2.00 ";
                assertEquals(output,ad1.testInputOutputs(file_input_path,file_output_path));
        }

	@Test
        public void testDisconnectedGraphs() {
                Average_Degree ad = new Average_Degree();
                String file_input_path = "tests/test-disconnected-graphs/tweet_input/tweets.txt";
                String file_output_path="tests/test-disconnected-graphs/tweet_output/output.txt";
                String output = "1.00 1.33 1.20 1.33 1.43 ";
                assertEquals(output,ad.testInputOutputs(file_input_path,file_output_path));
        }

	@Test
	public void testRepeatedHashtags() {
		Average_Degree ad = new Average_Degree();
                String file_input_path = "tests/test-repeated-hashtags/tweet_input/tweets.txt";
                String file_output_path="tests/test-repeated-hashtags/tweet_output/output.txt";
		String output = "2.00 2.00 2.00 2.50 2.40 ";
		assertEquals(output,ad.testInputOutputs(file_input_path,file_output_path));
	}
	
	@Test
	public void outOfOrderTweets1() {
		Average_Degree ad = new Average_Degree();
                String file_input_path = "tests/test-out-of-order-tweets1/tweet_input/tweets.txt";
                String file_output_path="tests/test-out-of-order-tweets1/tweet_output/output.txt";
		String output = "2.00 2.00 2.00 2.50 1.33 ";
		assertEquals(output,ad.testInputOutputs(file_input_path,file_output_path));
	}
	
	@Test
	public void outOfOrderTweets2() {
		Average_Degree ad = new Average_Degree();
                String file_input_path = "tests/test-out-of-order-tweets2/tweet_input/tweets.txt";
                String file_output_path="tests/test-out-of-order-tweets2/tweet_output/output.txt";
		String output = "2.00 2.00 2.00 2.50 2.40 ";
		assertEquals(output,ad.testInputOutputs(file_input_path,file_output_path));
	}
	
	@Test
	public void outOfOrderTweets3() {
		Average_Degree ad = new Average_Degree();
                String file_input_path = "tests/test-out-of-order-tweets3/tweet_input/tweets.txt";
                String file_output_path="tests/test-out-of-order-tweets3/tweet_output/output.txt";
		String output = "2.00 2.00 2.00 2.50 2.50 ";
		assertEquals(output,ad.testInputOutputs(file_input_path,file_output_path));
	}
	
	@Test
	public void outOfOrderTweets4() {
		Average_Degree ad = new Average_Degree();
                String file_input_path = "tests/test-out-of-order-tweets4/tweet_input/tweets.txt";
                String file_output_path="tests/test-out-of-order-tweets4/tweet_output/output.txt";
		String output = "2.00 2.00 2.00 2.50 2.50 ";
		assertEquals(output,ad.testInputOutputs(file_input_path,file_output_path));
	}

}
