package org.codehaus.mojo.fitnesse;

/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

import org.codehaus.mojo.fitnesse.plexus.FCommandLineException;
import org.codehaus.mojo.fitnesse.plexus.FCommandline;

public class MockCommandLine
    extends FCommandline
{

    private Process mProcess;

    public MockCommandLine( Process pProcess )
    {
        super();
        mProcess = pProcess;
    }

    /**
     * @Override
     */
    public Process execute()
        throws FCommandLineException
    {
        return mProcess;
    }

}
