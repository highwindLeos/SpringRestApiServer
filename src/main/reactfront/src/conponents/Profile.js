import React from 'react';

const Profile = (props) => {
    return (
        <div className="profile">
            <div className="profile__data">
                <h3 className="profile__name">{props.id}</h3>
                <h3 className="profile__name">{props.name}</h3>
                <h5 className="movie__year">{props.phone}</h5>
                <p className="profile__summary">{props.address}</p>
                <hr/>
            </div>
        </div>
    )
}
export default Profile;