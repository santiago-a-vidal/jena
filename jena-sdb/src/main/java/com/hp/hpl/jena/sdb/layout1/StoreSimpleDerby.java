/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hp.hpl.jena.sdb.layout1;

import com.hp.hpl.jena.sdb.StoreDesc;
import com.hp.hpl.jena.sdb.core.sqlnode.GenerateSQLDerby;
import com.hp.hpl.jena.sdb.layout2.TableDescTriples;
import com.hp.hpl.jena.sdb.sql.SDBConnection;

public class StoreSimpleDerby extends StoreBase1
{

    public StoreSimpleDerby(SDBConnection connection, StoreDesc desc)
    {
        this(connection, desc, new TableDescSPO(), new CodecSimple()) ;
    }

    private StoreSimpleDerby(SDBConnection connection, StoreDesc desc, TableDescTriples triples, EncoderDecoder codec)
    {
        super(connection, desc, 
              new FormatterSimpleDerby(connection) ,
              new TupleLoaderSimple(connection, triples, codec), 
              new QueryCompilerFactory1(codec), 
              new SQLBridgeFactory1(codec),
              new GenerateSQLDerby(),
              triples) ;
    }
}