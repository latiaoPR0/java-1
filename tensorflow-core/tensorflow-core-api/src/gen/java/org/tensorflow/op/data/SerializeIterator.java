/* Copyright 2018-2022 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
=======================================================================*/

// This class has been generated, DO NOT EDIT!

package org.tensorflow.op.data;

import java.util.Arrays;
import org.tensorflow.GraphOperation;
import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.RawOpInputs;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.OpInputsMetadata;
import org.tensorflow.op.annotation.OpMetadata;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.types.family.TType;

/**
 * Converts the given {@code resource_handle} representing an iterator to a variant tensor.
 */
@OpMetadata(
    opType = SerializeIterator.OP_NAME,
    inputsClass = SerializeIterator.Inputs.class
)
@Operator(
    group = "data"
)
public final class SerializeIterator extends RawOp implements Operand<TType> {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "SerializeIterator";

  private Output<? extends TType> serialized;

  @SuppressWarnings("unchecked")
  public SerializeIterator(Operation operation) {
    super(operation, OP_NAME);
    int outputIdx = 0;
    serialized = operation.output(outputIdx++);
  }

  /**
   * Factory method to create a class wrapping a new SerializeIterator operation.
   *
   * @param scope current scope
   * @param resourceHandle A handle to an iterator resource.
   * @param options carries optional attribute values
   * @return a new instance of SerializeIterator
   */
  @Endpoint(
      describeByClass = true
  )
  public static SerializeIterator create(Scope scope, Operand<? extends TType> resourceHandle,
      Options... options) {
    OperationBuilder opBuilder = scope.opBuilder(OP_NAME, "SerializeIterator");
    opBuilder.addInput(resourceHandle.asOutput());
    if (options != null) {
      for (Options opts : options) {
        if (opts.externalStatePolicy != null) {
          opBuilder.setAttr("external_state_policy", opts.externalStatePolicy);
        }
      }
    }
    return new SerializeIterator(opBuilder.build());
  }

  /**
   * Sets the externalStatePolicy option.
   *
   * @param externalStatePolicy the externalStatePolicy option
   * @return this Options instance.
   */
  public static Options externalStatePolicy(Long externalStatePolicy) {
    return new Options().externalStatePolicy(externalStatePolicy);
  }

  /**
   * Gets serialized.
   * A variant tensor storing the state of the iterator contained in the
   * resource.
   * @return serialized.
   */
  public Output<? extends TType> serialized() {
    return serialized;
  }

  @Override
  @SuppressWarnings("unchecked")
  public Output<TType> asOutput() {
    return (Output<TType>) serialized;
  }

  /**
   * Optional attributes for {@link org.tensorflow.op.data.SerializeIterator}
   */
  public static class Options {
    private Long externalStatePolicy;

    private Options() {
    }

    /**
     * Sets the externalStatePolicy option.
     *
     * @param externalStatePolicy the externalStatePolicy option
     * @return this Options instance.
     */
    public Options externalStatePolicy(Long externalStatePolicy) {
      this.externalStatePolicy = externalStatePolicy;
      return this;
    }
  }

  @OpInputsMetadata(
      outputsClass = SerializeIterator.class
  )
  public static class Inputs extends RawOpInputs<SerializeIterator> {
    /**
     * A handle to an iterator resource.
     */
    public final Operand<? extends TType> resourceHandle;

    /**
     * The externalStatePolicy attribute
     */
    public final long externalStatePolicy;

    public Inputs(GraphOperation op) {
      super(new SerializeIterator(op), op, Arrays.asList("external_state_policy"));
      int inputIndex = 0;
      resourceHandle = (Operand<? extends TType>) op.input(inputIndex++);
      externalStatePolicy = op.attributes().getAttrInt("external_state_policy");
    }
  }
}
