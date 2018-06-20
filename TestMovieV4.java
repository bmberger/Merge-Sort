
 /**
 * This class demonstrates the merge sort algorithm.
 *
 * @author Briana Berger
 * @version 06/17/17
 */

public class TestMovieV4
{
    public static void main(String[] args)
    {
        Movie[] movies = new Movie[10];
        Movie[] sorted = new Movie[10];

        movies[0] = new Movie("La La Land", 2016, "Summit Entertainment");
        movies[1] = new Movie("The Big Sick", 2017,"Lionsgate");
        movies[2] = new Movie("Gifted", 2017, "Fox Searchlight Pictures");
        movies[3] = new Movie("Hidden Figures", 2016, "20th Century Fox");
        movies[4] = new Movie("Mulan", 1988, "Walt Disney");
        movies[5] = new Movie("One Day", 2011, "Random House Films");
        movies[6] = new Movie("Becoming Jane", 2007, "HanWay Films");
        movies[7] = new Movie("Brooklyn", 2015, "BBC Films");
        movies[8] = new Movie("Divergent", 2014, "Lionsgate");
        movies[9] = new Movie("Harry Potter", 2001, "Warner Bros");
        
        System.out.println("    <<<< Before Sorting >>>> \n");
        printArray(movies);
        
        System.out.println("\n     <<<< After Sorting >>>>");
        System.out.println("<<<< by title ascending - passing an array and order >>>>\n");
        mergeSort(movies, 0, movies.length-1, "Title");
        printArray(movies);
        
        System.out.println("\n     <<<< After Sorting >>>>");
        System.out.println("<<<< by year ascending - passing an array and order >>>>\n");
        mergeSort(movies, 0, movies.length-1, "Year");
        printArray(movies);
        
        System.out.println("\n     <<<< After Sorting >>>>");
        System.out.println("<<<< by studio ascending - passing an array and order >>>>\n");
        mergeSort(movies, 0, movies.length-1, "Studio");
        printArray(movies);
    }
    
    public static void printArray(Movie[] source)
    {
        for(int i = 0; i < source.length; i++)
            System.out.println(source[i]);
            
        System.out.println();
    }
    
    public static void mergeSort(Movie[] source, int low, int high, String type)
    {
        if( low == high )
            return;

        int mid = ( low + high ) / 2;
        
        if(type.equals("Title"))
        {
            mergeSort( source, low, mid, "Title");
            mergeSort( source, mid + 1, high, "Title"); 
            mergeTitle( source, low, mid, high);
        }
        else if(type.equals("Year"))
        {
            mergeSort( source, low, mid, "Year");
            mergeSort( source, mid + 1, high, "Year"); 
            mergeYear( source, low, mid, high);
        }
        else if(type.equals("Studio"))
        {
            mergeSort( source, low, mid, "Studio");
            mergeSort( source, mid + 1, high, "Studio"); 
            mergeStudio( source, low, mid, high);
        }
    }
    
    public static void mergeTitle(Movie[] source, int low, int mid, int high)
    { 
        Movie[] dest = new Movie[ high - low + 1 ];

        int i = low, j = mid + 1, n = 0;

        while( i <= mid || j <= high )
        {
            if( i > mid )
            {
                dest[ n ] = source[ j ];
                j++;
            }
            else if( j > high )
            {
                dest[ n ] = source[ i ];
                i++;
            }
            else if( source[ i ].getTitle().compareTo(source[ j ].getTitle()) < 0)
            {
                dest[ n ] = source[ i ];
                i++;
            }
            else
            {
                dest[ n ] = source[ j ];
                j++;
            }
            n++;
        }

        for( int k = low ; k <= high ; k++ )
            source[ k ] = dest[ k - low ];
    }
    
    public static void mergeYear(Movie[] source, int low, int mid, int high)
    {
        Movie[] dest = new Movie[ high - low + 1 ];

        int i = low, j = mid + 1, n = 0;

        while( i <= mid || j <= high )
        {
            if( i > mid )
            {
                dest[ n ] = source[ j ];
                j++;
            }
            else if( j > high )
            {
                dest[ n ] = source[ i ];
                i++;
            }
            else if( source[ i ].getYear() < source[ j ].getYear())
            {
                dest[ n ] = source[ i ];
                i++;
            }
            else
            {
                dest[ n ] = source[ j ];
                j++;
            }
            n++;
        }

        for( int k = low ; k <= high ; k++ )
            source[ k ] = dest[ k - low ];
    }
    
    public static void mergeStudio(Movie[] source, int low, int mid, int high)
    {
        Movie[] dest = new Movie[ high - low + 1 ];

        int i = low, j = mid + 1, n = 0;

        while( i <= mid || j <= high )
        {
            if( i > mid )
            {
                dest[ n ] = source[ j ];
                j++;
            }
            else if( j > high )
            {
                dest[ n ] = source[ i ];
                i++;
            }
            else if( source[ i ].getStudio().compareTo(source[ j ].getStudio()) < 0)
            {
                dest[ n ] = source[ i ];
                i++;
            }
            else
            {
                dest[ n ] = source[ j ];
                j++;
            }
            n++;
        }

        for( int k = low ; k <= high ; k++ )
            source[ k ] = dest[ k - low ];
    }
} // end of class
