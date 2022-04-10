import axios from "axios"

export default {
    register ({ commit}, credentials) {
        return axios.post('http://localhost:7777/member/register', credentials)
                    .then(({data}) => {
                        console.log ('user data is:' + data)
                        commit ('SET_USER_DATA', data)
                    })
    },
    login ({ commit }, loginObj ) {
    
        console.log(loginObj)

        // 로그인 -> 토큰 반환 
        return axios.post('http://localhost:7777/member/login',  loginObj )
        .then ((res) => {

            console.log(res.data)
            commit('loginSuccess', res)
           //토큰을 헤더에 포함시켜서 멤버 정보 요청
            let token = res.data.token
            let config = {
                        headers: {
                            "access-token": token
                        }
                    }
            // 토큰을 로컬스토리지에 저장
            localStorage.setItem("access_token", config)
            console.log(config)
            console.log("로그인 완료!")
            //dispatch("getMemberInfo")
            
        }).catch (() => {
            alert ('아이디와 비밀번호를 확인하세요.')
        })
    },
    logout ({ commit }) {
        commit('logout')
        this.$router.push({ path: '/mainPage' })
                    .then(() => {
                        alert ('로그아웃 되었습니다.')
                    })
      },
    // getMemberInfo({ commit }) {
    //     //로컬스토리지에 저장된 토큰을 불러온다
    //     let token = localStorage.getItem("access_token")

    //     let config = {
    //         headers: {
    //             "access-token": token
    //         }
    //     }
    //         // 토큰을 가지고 -> 멤버 정보를 반환 
    //         // 새로고침 시 id와 pw를 다시 입력하지 않고 토큰만 가지고 멤버정보를 요청
    //         axios.get('http://localhost:7777/member/${memberNo}', config)
    //         .then(response => {
    //             // let userInfo = {
    //             //     id: response.data.data.id,
    //             //     pw: response.data.data.pw,
    //             //     auth: response.data.data.auth
    //             // }

    //             commit("loginSuccess" , response)
    //         })
    //         .catch(() => {
    //             alert ('이메일과 비밀번호를 확인하세요.')
    //         })
    // }
}