/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.puredev;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

import java.util.concurrent.TimeUnit;

@Slf4j
public class MyBenchmark {


    //In case if we want to pass state object to benchmark method instead of instantiating it inside benchmark method then we can use this annotation.
    // It must be put on public class with no arg constuctor. Scope defines how instance will be shared among benchmark method executions.
    // Thread - New instance will be created for each executing thread
    // Group - New instance will be created for each thread group
    // Benchmark - All threads will share the same state object.
    @State(value = Scope.Thread)
    public static class MyState {
      int a;
      int b;
      int sum;

      /**
       * This method will be called before benchmark method call and is intended to initialize state.
       * Note: Its duration is not shown in benchmarks.
       * The level controls when the this method will be called:
       *
       * Trial - Indicates that the method will be called for each fork(including warmup and interations)
       * Iteration - Means that method will be called for each warmup or usual iteration.
       * Invocation - As name states it will be called before each benchmark method call.
       */
      @Setup(value = Level.Trial)
      public void doSetup() {
        log.info("Do Setup called !!!!");
      }

      /**
       * The same logic for levels is applied here with one difference that it is called after benchmark method, after iteration and after fork.
       */
      @TearDown(value = Level.Trial)
      public void doCleanup() {
        log.info("Do Cleanup called !!!!");
      }
    }

    @Benchmark
    @BenchmarkMode(value = Mode.AverageTime)
    @OutputTimeUnit(value = TimeUnit.MILLISECONDS)
    public void testMethod(MyState state) {
//      log.info("Calling benchmark method !!!!");
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.

      state.sum = state.a + state.b;

    }

}
