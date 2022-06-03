import axios from "axios"
import router from "../router/index.js"

axios.defaults.baseURL = "http://localhost:1234/api/"


axios.interceptors.request.use((config) =>
    
    {
        if (localStorage.getItem("access_token"))
            config.headers.common['Authorization'] = `Bearer ${localStorage.getItem("access_token")}`
        return config
    },

    (error) => {
        return Promise.reject(error)
    }
    
)

axios.interceptors.response.use((response)=>{return response}, async (error) => 
    {

        const originalRequest = error.config

        if (error.response.status === 401 && !originalRequest._retry && localStorage.getItem("access_token")){
            
            originalRequest._retry = true
            const {status,data} = await axios.post('refreshtoken', {}, {withCredentials: true})

            if (status === 200){
                localStorage.setItem("access_token", data.access_token)
                originalRequest.headers['Authorization'] = `Bearer ${data.access_token}`
                return axios(originalRequest)
            }
        }
        else if (error.response.status === 403){
            alert("해당 요청에 대한 권한이 없습니다")
            router.push({name:"home"})
        }    
    return error    
    }
    
)
