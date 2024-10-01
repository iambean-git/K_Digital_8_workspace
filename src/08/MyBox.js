import MyBoxFlag from "./MyBoxFlag";

export default function MyBox() {
    

    return (
        <div className="flex justify-center items-center w-full h-screen">
            <MyBoxFlag color="blue" />
            <MyBoxFlag color='lime' />
        </div>
    )
}
