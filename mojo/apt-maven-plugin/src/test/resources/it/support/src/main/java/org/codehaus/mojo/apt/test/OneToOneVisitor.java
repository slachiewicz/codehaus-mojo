package org.codehaus.mojo.apt.test;

/*
 * The MIT License
 *
 * Copyright 2006-2008 The Codehaus.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.Filer;
import com.sun.mirror.declaration.ClassDeclaration;
import com.sun.mirror.util.SimpleDeclarationVisitor;

/**
 * Simple apt visitor for use by integration tests. This visitor creates an empty corresponding text file for each class
 * visited.
 * 
 * @author <a href="mailto:markhobson@gmail.com">Mark Hobson</a>
 * @version $Id$
 */
public class OneToOneVisitor extends SimpleDeclarationVisitor
{
    // fields -----------------------------------------------------------------

    private final AnnotationProcessorEnvironment environment;

    // constructors -----------------------------------------------------------

    public OneToOneVisitor( AnnotationProcessorEnvironment environment )
    {
        this.environment = environment;
    }

    // AnnotationProcessor methods --------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public void visitClassDeclaration( ClassDeclaration declaration )
    {
        PrintWriter writer = null;

        try
        {
            Filer filer = environment.getFiler();

            String packageName = declaration.getPackage().getQualifiedName();
            File relativePath = new File( declaration.getQualifiedName() + ".txt" );
            writer = filer.createTextFile( Filer.Location.CLASS_TREE, packageName, relativePath, null );
        }
        catch ( IOException exception )
        {
            environment.getMessager().printError( exception.toString() );
        }
        finally
        {
            if ( writer != null )
            {
                writer.close();
            }
        }
    }
}
