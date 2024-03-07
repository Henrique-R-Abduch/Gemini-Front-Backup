import Link from "next/link";
import { PlusIcon } from '@heroicons/react/24/solid'

export default function Button({children, icon, type="link", ...props}) {
    return (
        (type === "link") ?
        <Link href="#" {...props} className="bg-emerald-800 px-2 py-1 rounded flex gap-1 hover:bg-emerald-900">{children} {icon}</Link>
        :
        <button  {...props} className="bg-emerald-800 px-2 py-1 rounded flex gap-1 hover:bg-emerald-900">{children} {icon}</button>
        )
}