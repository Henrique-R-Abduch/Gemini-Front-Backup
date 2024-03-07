import DropDown from "@/components/dropdown";

export default function DataRow({ categoria }){
    return (
        <div id="data-row" className='flex justify-between'>
                  <span>{categoria.descricao}</span>
                  <span>{categoria.data}</span>
                  <span>{categoria.valor}</span>
                  <span>{categoria.tipo}</span>
                  <DropDown/>
                </div>
    )
}