package org.codehaus.mojo.jslint;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */

import java.io.File;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * Goal which reports on the source files using JSLint.
 * 
 * @goal main-jslint
 * @phase process-sources
 */
public class JSLintMojo
    extends AbstractJSLintMojo
{
    /**
     * The source JavaScript folder.
     * 
     * @parameter default-value="${basedir}/src/main/js"
     * @required
     */
    private File sourceJsFolder;

    /**
     * Execute the MOJO.
     * 
     * @throws MojoExecutionException if something unexpected occurs.
     */
    public void execute()
        throws MojoExecutionException
    {
        doExecute( sourceJsFolder, Scope.COMPILE );
    }

    /**
     * @return property.
     */
    public File getSourceJsFolder()
    {
        return sourceJsFolder;
    }

    /**
     * @param sourceJsFolder set property.
     */
    public void setSourceJsFolder( File sourceJsFolder )
    {
        this.sourceJsFolder = sourceJsFolder;
    }
}
