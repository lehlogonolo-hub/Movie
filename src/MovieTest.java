import java.util.HashMap;

public class MovieTest
{
    private static int yourExamScore = 0;


    public static void main(String[] args)
    {
        test1();    // movies must be released between 1888 and 2021
        test2();    // Movie's parent is EntertainmentMedia; EntertainmentMedia's parent is Media
        test3();    // Movie's title must not be null, must not be empty, must not be "the movie" (in any letter case)
        test4();    // HashMap: key is last name, value is full name (e.g."Woods"=>"Tiger Woods")

        System.out.println("Your score is " + yourExamScore + " out of 13.");
    }

    // checking: movies must be released between 1888 and 2021
    private static void test1()
    {
        try
        {
            Movie movie = new Movie("my movie", 2022);
            System.out.println("Error. Movies must only be released from 1888-2021, not 2022");
        }
        catch(InvalidMovieYearException e)
        {
            if(e.getMessage().equals("2022 is not a valid movie year..."))
            {
                yourExamScore++;
            }
            else
            {
                System.out.println("Error. Wrong Exception message; should have said \"2022 is not a valid movie year...\"");
                System.out.println("Your message said " + e.getMessage());
            }
        }
        catch(Exception e)
        {
            System.out.println("Error. Wrong Exception type: should have been InvalidMovieYearException");
            System.out.println("Your type was " + e.getClass().getSimpleName());
        }

        try
        {
            Movie movie = new Movie("my movie", 1887);
            System.out.println("Error. Movies must only be released from 1888-2021, not 1887");
        }
        catch(InvalidMovieYearException e)
        {
            if(e.getMessage().equals("1887 is not a valid movie year..."))
            {
                yourExamScore++;
            }
            else
            {
                System.out.println("Error. Wrong Exception message; should have said \"1887 is not a valid movie year...\"");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error. Wrong Exception type: should have been InvalidMovieYearException");
            System.out.println("Your type was " + e.getClass().getSimpleName());
        }

        try
        {
            Movie movie = new Movie("my movie", 1930);
            if(movie.getYearReleased() == 1930)
            {
                yourExamScore++;
            }
            else
            {
                System.out.println("Error. Expected this movie to report that it was released in 1920");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error. Should not have got an Exception for my movie released in 1930");
        }
    }

    // Checking: Movie's parent is EntertainmentMedia; EntertainmentMedia's parent is Media
    private static void test2()
    {
        try
        {
            Movie movie = new Movie("my movie", 1930);
            if(movie instanceof EntertainmentMedia)
            {
                yourExamScore++;
            }
            else
            {
                System.out.println("Error. Movie's parent is supposed to be class EntertainmentMedia");
            }

            if(movie instanceof Media)
            {
                yourExamScore++;
            }
            else
            {
                System.out.println("Error. EntertainmentMedia's parent is supposed to be class Media");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error. This movie should have been created with no Exception");
        }
    }

    // checking: Movie's title must not be null, must not be empty, must not be "the movie" (in any letter case)
    private static void test3()
    {
        try
        {
            Movie movie = new Movie(null, 1930);
            System.out.println("Error. Should be getting an Exception for null title");
        }
        catch(Exception e)
        {
            yourExamScore++;
        }

        try
        {
            Movie movie = new Movie("", 1930);
            System.out.println("Error. Should be getting an Exception for empty title");
        }
        catch(Exception e)
        {
            yourExamScore++;
        }

        try
        {
            Movie movie = new Movie("tHe MoviE", 1930);
            System.out.println("Error. Should be getting an Exception for \"the movie\" (in any letter casing)");
        }
        catch(Exception e)
        {
            yourExamScore++;
        }
    }

    // Checking: HashMap: key is last name, value is full name (e.g."Woods"=>"Tiger Woods")
    private static void test4()
    {
        try
        {
            Movie movie = new Movie("my movie", 1930);
            HashMap<String, String> actors = new HashMap<String, String>();
            actors = movie.getActors();

            if (actors.size() == 0)
            {
                yourExamScore++;
            } else
            {
                System.out.println("Error. There should be no actors yet");
            }

            movie.addActor("Katarina Vencel");
            movie.addActor("Arieh Hiba");
            movie.addActor("Tushar Leopold");
            movie.addActor("Amis Sofie");

            actors = new HashMap<String, String>();
            actors = movie.getActors();

            if (actors.get("Vencel").equals("Katarina Vencel"))
            {
                yourExamScore++;
            }
            else
            {
                System.out.println("Error. getActors should return HashMap with key Vencel and value Katerina Vencel");
            }

            if (actors.get("Hiba").equals("Arieh Hiba"))
            {
                yourExamScore++;
            }
            else
            {
                System.out.println("Error. getActors should return HashMap with key Hiba and value Arieh Hiba");
            }

            if (actors.get("Leopold").equals("Tushar Leopold"))
            {
                yourExamScore++;
            }
            else
            {
                System.out.println("Error. getActors should return HashMap with key Leopold and value Tushar Leopold");
            }

            if(actors.get("Sofie").equals("Amis Sofie"))
            {
                yourExamScore++;
            }
            else
            {
                System.out.println("Error. getActors should return HashMap with key Sofie and value Amis Sofie");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error. Should be creating a valid Movie object here...");
            System.out.print("Your Exception was " + e.getClass().getSimpleName());
            System.out.println(" with message " + e.getMessage());
        }
    }

}
