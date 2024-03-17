"use client"
import {create} from "@/actions/categorias"
import InputText from "@/components/input-text";
import NavBar from "@/components/navbar";
import Button from "@/components/button";
import { useRouter } from "next/navigation";
import toast from "react-hot-toast";
import ComboBoxIconeCategoria from "@/components/combobox-icone-categoria";

export default function categoriaNew() {
    const {push} = useRouter()

    async function onSubmit(formData){
        const resp = await create(formData)

        if (resp?.error) {
            toast.error(resp.error)
            return
        }
        push("/productregistration")
    }

    return (
        <><NavBar />
        <main className="justify-center gap-16 container  bg-slate-800 mt-16 mx-auto rounded p-4 items-center max-w-xl">
            <h2 className="items-center flex flex-col">Cadastrar Categoria</h2>
            <form action={onSubmit} className="flex flex-col items-center gap-2 mt-2 mx-auto">
                <ComboBoxIconeCategoria/>
                <InputText name="descricao" label="descricao"/>
                <InputText name="data" label="data"/>
                <InputText name="valor" label="valor"/>
                <InputText name="tipo" label="tipo"/>
                <Button type="button">Salvar</Button>
            </form>
        </main></>
    )
}