/*
 * CDDL HEADER START
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License (the "License").
 * You may not use this file except in compliance with the License.
 *
 * See LICENSE.txt included in this distribution for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL HEADER in each
 * file and include the License file at LICENSE.txt.
 * If applicable, add the following below this CDDL HEADER, with the
 * fields enclosed by brackets "[]" replaced with your own identifying
 * information: Portions Copyright [yyyy] [name of copyright owner]
 *
 * CDDL HEADER END
 */

/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
 */

package org.opensolaris.opengrok.analysis.scala;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import org.opensolaris.opengrok.analysis.Definitions;
import org.opensolaris.opengrok.analysis.FileAnalyzer;
import org.opensolaris.opengrok.analysis.FileAnalyzer.Genre;
import org.opensolaris.opengrok.analysis.FileAnalyzerFactory;
import org.opensolaris.opengrok.configuration.Project;
import org.opensolaris.opengrok.history.Annotation;

/**
 *
 * @author Ajay K
 */

public class ScalaAnalyzerFactory extends FileAnalyzerFactory {

    private static final String name = "Scala";
    
    private static final String[] SUFFIXES = {
        "SCALA"
    };

    public ScalaAnalyzerFactory() {
        super(null, null, SUFFIXES, null, null, "text/plain", Genre.PLAIN, name);
    }

    @Override
    protected FileAnalyzer newAnalyzer() {
        return new ScalaAnalyzer(this);
    }

    @Override
    public void writeXref(Reader in, Writer out, Definitions defs, Annotation annotation, Project project)
        throws IOException {
         ScalaAnalyzer.writeXref(in, out, defs, annotation, project);
    }
}
