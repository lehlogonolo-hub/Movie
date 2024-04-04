import java.util.HashMap;
import java.util.Map;

/**
 * Movie class
 *
 * @author Aphane Jimmy
 * @version 1.0
 */
public class Movie extends EntertainmentMedia
{
    private final String movieTitle;
    private final int yearReleased;
    private final Map<String, String> actorsList;


    private static final int MIN_YEAR_RELEASED = 1888;
    private static final int MAX_YEAR_RELEASED = 2021;

    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    private static final int ACTOR_MIN_SIZE = SECOND_INDEX;
    private static final int ARRAY_LENGTH = 2;


    /**
     * This is the Movie Class Constructor
     *
     * @param movieTitle the title of the movie
     * @param yearReleased the year of the movie
     */
    public Movie(final String movieTitle, final int yearReleased) throws IllegalArgumentException, InvalidMovieYearException
    {
        super(movieTitle, yearReleased);

        this.movieTitle = movieTitle;
        this.yearReleased = yearReleased;
        actorsList = new HashMap<>();

        validateYearReleased(yearReleased);
        setMovieTitle(movieTitle);
    }

    public void validateYearReleased(final int yearReleased) throws InvalidMovieYearException
    {
        if (yearReleased < MIN_YEAR_RELEASED || yearReleased > MAX_YEAR_RELEASED)
        {
            throw new InvalidMovieYearException(yearReleased + " is not a valid movie year...");
        }
    }

    public int getYearReleased()
    {
        return yearReleased;
    }

    public String getMovieTitle()
    {
        return movieTitle;
    }

    public void setMovieTitle(final String movieTitle) throws IllegalArgumentException, NullPointerException
    {
        if (movieTitle == null)
        {
            throw new NullPointerException("Invalid movie title: " + null);
        }
        if (movieTitle.isEmpty() || movieTitle.equalsIgnoreCase("the movie"))
        {
            throw new IllegalArgumentException("Invalid movie title: " + movieTitle);
        }
    }


    /**
     * This is the get actors method
     *
     * @return this will return the HashMap of actors
     */
    public HashMap<String, String> getActors()
    {
        HashMap<String, String> actors = new HashMap<>();

        for (Map.Entry<String, String> entry : actorsList.entrySet())
        {
            String lastName = entry.getKey();
            String firstName = entry.getValue();
            String fullName = firstName + " " + lastName;
            actors.put(lastName, fullName);
        }
        return actors;
    }


    /**
     * This is the add actors method
     *
     * @param peopleActors actor to be added
     */
    public void addActor(final String peopleActors)
    {
        String[] arrayValues = peopleActors.split(" ");
        if (arrayValues.length != ARRAY_LENGTH)
        {
            throw new IllegalArgumentException("Invalid actor format: " + peopleActors);
        }
        String firstName = arrayValues[FIRST_INDEX];
        String lastName = arrayValues[SECOND_INDEX];

        actorsList.put(lastName, firstName);
    }

}
