/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.statistics.metrics

import org.jetbrains.kotlin.statistics.ValueAnonymizer
import org.jetbrains.kotlin.statistics.anonymizeComponentVersion
import org.jetbrains.kotlin.statistics.sha256


enum class StringOverridePolicy: IMetricContainerFactory<String> {
    OVERRIDE {
        override fun newMetricContainer(): IMetricContainer<String> = OverrideMetricContainer<String>()
    },
    CONCAT {
        override fun newMetricContainer(): IMetricContainer<String> = ConcatMetricContainer()
    },
    COUNT {
        override fun newMetricContainer(): IMetricContainer<String> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}

enum class NumberOverridePolicy: IMetricContainerFactory<Long> {
    OVERRIDE {
        override fun newMetricContainer(): IMetricContainer<Long> = OverrideMetricContainer<Long>()
    },
    SUM {
        override fun newMetricContainer(): IMetricContainer<Long> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    },
    AVERAGE {
        override fun newMetricContainer(): IMetricContainer<Long> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}

enum class BooleanOverridePolicy: IMetricContainerFactory<Boolean> {
    OVERRIDE {
        override fun newMetricContainer(): IMetricContainer<Boolean> = OverrideMetricContainer<Boolean>()
    },
    DISTRIBUTION {
        override fun newMetricContainer(): IMetricContainer<Boolean> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}

enum class BooleanAnonymizationPolicy : ValueAnonymizer<Boolean> {
    SAFE {
        override fun anonymize(t: Boolean) = t
    }
}

enum class StringAnonymizationPolicy : ValueAnonymizer<String> {
    SAFE {
        //TODO add list restriction
        override fun anonymize(t: String) = t
    },
    SHA_256 {
        override fun anonymize(t: String) = sha256(t)
    },
    COMPONENT_VERSION {
        override fun anonymize(t: String) = anonymizeComponentVersion(t)
    }
}

enum class NumberAnonymizationPolicy : ValueAnonymizer<Long> {
    SAFE {
        override fun anonymize(t: Long) = t
    },
    RANDOM_10_PERCENT {
        override fun anonymize(t: Long) = (t + t * 0.1 * Math.random()).toLong()
    },
    RANDOM_01_PERCENT {
        override fun anonymize(t: Long) = (t + t * 0.01 * Math.random()).toLong()
    }
}

