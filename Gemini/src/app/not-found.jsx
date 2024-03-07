import Button from "@/components/button";
import NavBar from "@/components/navbar";
import Link from "next/link";


export default function NotFound() {
    return (
        <>
        <main className="justify-center flex gap-16 container bg-slate-800 mt-16 mx-auto rounded p-4 items-center max-w-lg">
            <h2>Página não encontrada</h2>
            
        </main>
        <div className="justify-center flex gap-16 container bg-slate-800 mt-16 mx-auto rounded p-4 items-center max-w-lg">
            <Button href="/">Voltar para a home</Button>
        </div>

        
        </>
    )
}