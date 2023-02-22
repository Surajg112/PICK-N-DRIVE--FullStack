function About(){
    return (
        <>
        <div className="page-heading about-heading header-text" style={{backgroundImage: 'url(images/heading-1-1920x500.jpg)'}}>
        <div className="container">
            <div className="row">
            <div className="col-md-12">
                <div className="text-content">
                <h4>about us</h4>
                <h2>Pickup-N-Drive</h2>
                </div>
            </div>
            </div>
        </div>
        </div>
        <div className="best-features about-features">
        <div className="container">
            <div className="row">
            <div className="col-md-12">
                <div className="section-heading">
                <h2>We are providing car on rents</h2>
                </div>
            </div>
            <div className="col-md-6">
                <div className="right-image">
                <img src="images/Aboutus-Image.jpg" alt />
                </div>
            </div>
            <div className="col-md-6">
                <div className="left-content">
                <h4>Pickup-N-Drive</h4>
                <p>We will lead our industry by defining service excellence and building unmatched customer loyalty. 
                We will ensure a stress-free car rental experience by providing superior services that cater to our customers' individual needs...always conveying the 'We Try Harder®' 
                spirit with knowledge, caring and a passion for excellence<br /><br />
                We will honour all commitments to our customers, employees, and shareholders 
                We will conduct business with unwavering high standards of honesty, trust, professionalism and ethical behaviour.
               We will communicate openly and frequently, sharing what we know, when we know it</p>
                <ul className="social-icons">
                    <li><a href="#" className="fa fa-facebook"></a></li>
                    <li><a href="#"><i className="fa fa-twitter" /></a></li>
                    <li><a href="#"><i className="fa fa-linkedin" /></a></li>
                    <li><a href="#"><i className="fa fa-behance" /></a></li>
                </ul>
                </div>
            </div>
            </div>
        </div>
        </div>

        </>
    )
}

export default About;