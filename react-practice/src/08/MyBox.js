import MyBoxFlag from "./MyBoxFlag";

export default function MyBox() {


    return (
        <div className="flex justify-center items-center w-full h-screen">
            <div className="w-10/12 grid grid-cols-2 gap-4">
                <MyBoxFlag color="blue" />
                <MyBoxFlag color="violet" />
                <MyBoxFlag color='lime' />
                <MyBoxFlag color="orange" />
            </div>

        </div>
    )
}
