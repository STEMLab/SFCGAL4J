/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2015, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package edu.pnu.stem.sfcgal4j;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.StdString;

/**
 * @author Donguk Seo
 *
 */
@Platform(include = "cpp/SFMultiSolid.h", link = "SFCGAL")
public class SFMultiSolid extends SFGeometryCollection {
        static {
                Loader.load();
        }

        public SFMultiSolid() {
                allocate();
        }

        public SFMultiSolid(Pointer p) {
                super(p);
        }

        private native void allocate();

        @Name("operator=")
        public native @ByRef SFMultiSolid assign(@ByRef SFMultiSolid other);

        public native SFMultiSolid clone();

        public native @StdString String geometryType();

        public native int geometryTypeId();

        public native @ByRef SFSolid solidN(@Cast("size_t") int n);

}