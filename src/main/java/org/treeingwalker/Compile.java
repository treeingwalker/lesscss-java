package org.treeingwalker;

import org.treeingwalker.logging.LessLogger;
import org.treeingwalker.logging.LessLoggerFactory;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Compile class.</p>
 *
 * @author tdurbin
 * @version $Id: $
 */
public class Compile {

    private static final LessLogger logger = LessLoggerFactory.getLogger( Compile.class );

	/**
	 * <p>main.</p>
	 *
	 * @param args a {@link java.lang.String} object.
	 * @throws java.lang.Exception if any.
	 */
	public static void main(String... args) throws Exception {
		if( args.length < 1 ) {
		    logger.info("usage: org.lesscss.Compile <args> <less_filename>");
            System.exit(-1);
		}
		
		List<String> argList = Arrays.asList(args);
		String fileName = argList.get(argList.size() - 1);
		argList = argList.subList(0, argList.size() - 1);

        File output = new File( fileName + ".css" );
        logger.info("Compiler output = %s", output.getCanonicalPath() );

        long start = System.currentTimeMillis();
		LessCompiler lessCompiler = new LessCompiler(argList);
		
		lessCompiler.compile( new File( fileName ), output );
		
        long duration = System.currentTimeMillis() - start;
        logger.info("Done. %,d ms", duration);
	}
}
