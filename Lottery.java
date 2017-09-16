import java.util.Random;   // Needed for Random class

/**
   Alex Waters id# 23598844
   1st project CSC 210 - 1701
   Comp. Prog. II 5:20PM - 7:35PM
   Fiterman Hall 906 
   Instructor: Alam Miah
   RainFall Test Program Chapter 7 #10
*/

public class Lottery
{
   // Fields
   final int PICK_FIVE = 5;
   private int[] lotteryNumbers = new int[PICK_FIVE];
   private int[] usersLottoPicks = new int[PICK_FIVE];
   
   /**
      Constructor
      Uses Random object to create
      lotto numbers for program.
   */
   
   public Lottery()
   {
      // Create Random object for lottery.
      Random randomNumbers = new Random();
      
      // Get randomNumbers and assign integrs
      // to lotteryNumbers array.
      for(int index = 0; index < lotteryNumbers.length; index++)
      {
         lotteryNumbers[index] = randomNumbers.nextInt(10);
      }
   }
      
   /**
      getLotteryNumbers method
      @return The five lottery numbers.
   */
      
   public int[] getLotteryNumbers()
   {
      return lotteryNumbers;
   }
      
   /**
      setUsersLotteryPicks method
      @param lotteryPicks Array of users lottery picks
                          from program.
   */
      
   public void setUsersLotteryPicks(int[] lotteryPicks)
   {
      // Copy parameter array and assign
      // to usersLottoPicks array field.
      for(int index = 0; index < lotteryPicks.length; index++)
      {
         usersLottoPicks[index] = lotteryPicks[index];
      }
   }
      
   /**
      getUsersLotteryPicks method
      @return UsersLottoPicks array.
   */
      
   public int[] getUsersLotteryPicks()
   {
      return usersLottoPicks;
   }
      
      
}
