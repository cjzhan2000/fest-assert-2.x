/*
 * Created on Mar 29, 2009
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2013 the original author or authors.
 */
package org.fest.assertions.api;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.util.StackTraceUtils.hasStackTraceElementRelatedToFest;

import org.fest.assertions.api.Fail;
import org.junit.Test;

/**
 * Tests for {@link Fail#setRemoveFestRelatedElementsFromStackTrace(boolean)}.
 *
 * @author Joel Costigliola
 * @author Yvonne Wang
 */
public class Fail_fest_elements_stack_trace_filtering_Test {

  @Test
  public void fest_elements_should_be_removed_from_assertion_error_stack_trace() {
    Fail.setRemoveFestRelatedElementsFromStackTrace(true);
    try {
      assertThat(5).isLessThan(0);
    } catch (AssertionError assertionError) {
      assertThat(hasStackTraceElementRelatedToFest(assertionError)).isFalse();
    }
  }

  @Test
  public void fest_elements_should_be_kept_in_assertion_error_stack_trace() {
    Fail.setRemoveFestRelatedElementsFromStackTrace(false);
    try {
      assertThat(5).isLessThan(0);
    } catch (AssertionError assertionError) {
      assertThat(hasStackTraceElementRelatedToFest(assertionError)).isTrue();
    }
  }

}
