/**
 * Media class
 *
 * @author Aphane Jimmy
 * @version 1.0
 */
public class Media
{
    private final String movieName;
    private final int yearPublished;

    /**
     * Media Constructor
     */
    public Media(final String movieName, final int yearPublished)
    {
        this.movieName = movieName;
        this.yearPublished = yearPublished;
    }

    public String getMovieName() { return movieName; }

    public int getYearPublished()
    {
        return yearPublished;
    }
}