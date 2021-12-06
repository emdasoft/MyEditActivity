package org.mcalc.editactivity

import java.io.Serializable

data class Check(val imageId: Int, val name: String, val amount: Double, val desc: String) : Serializable
