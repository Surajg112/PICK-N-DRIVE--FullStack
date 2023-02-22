import AdminNav from "./Adminnav"

const Dashboard=()=>{
    return(
        <>
        <div className="container-fluid">
            <div className="row">
                <div className="col-sm-2 bg-transparent p-0 border-right border-primary" style={{height:"calc(100vh - 80px)"}}>
                    <AdminNav />
                </div>
                <div className="col-sm-10">
                    <h4 className="p-2 border-bottom border-success">Admin Dashboard</h4>
                </div>
            </div>
        </div>
        </>
    )
}

export default Dashboard;