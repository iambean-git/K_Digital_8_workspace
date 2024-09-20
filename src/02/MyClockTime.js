function MyClockTime() {
    let today = new Date();
    today = today.toLocaleTimeString();

    return (
        <>
        현재시각 : {today}
        </>
    );
}

export default MyClockTime;