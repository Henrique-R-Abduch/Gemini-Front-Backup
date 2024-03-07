"use server"

import { revalidatePath } from "next/cache"

const url = "http://localhost:8080/movimentacao"

export async function create(data) {
    
    
    const options = {
        method: "POST",
        body: JSON.stringify(Object.fromEntries(data)),
        headers: {
            "Content-Type": "application/json"
        }
        
    }
    
    const resp = await fetch(url, options)

    if (resp.status !== 201) return {error: "erro ao cadastrar"}

    revalidatePath("/productregistration")

}

export async function destroy(id) {
    const options = {
        method: "DELETE",
        body: JSON.stringify(Object.fromEntries(data)),
        headers: {
            "Content-Type": "application/json"
        }     
}}