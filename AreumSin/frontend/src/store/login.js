const state = {
    userData: []
};

const getters = {
    userInfo: state => state.userData
}

const mutations = {
    addUser (state, userInfo) {
        console.log(userInfo);
        //state.userInfo = state.userInfo.concat(userInfo);
        /*for(let i = 0; i < userInfo.length; i++){
            //state.userInfo[i] = userInfo[i];
            console.log("addUser() " + state.userInfo);
        }*/

        state.userInfo = userInfo;
        for(let i = 0; i < userInfo.length; i++){
            //state.userInfo[i] = userInfo[i];
            console.log("addUser() " + state.userInfo[i]);
        }
    }
};

const actions = {
    addUser({commit}, data){
        commit("addUser", data);
    }
}

export default {
    strict: process.env.NODE_ENV !== "production",
    state: {
        ...state
    },
    mutations,
    getters,
    actions,
}