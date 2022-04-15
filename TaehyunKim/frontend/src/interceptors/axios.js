import axios from "axios"

axios.defaults.baseURL = "http://localhost:1234/api/"


axios.interceptors.request.use((config) =>
    
    {
        console.log("Interceptor before request")
        config.headers.common['Authorization'] = `Bearer ${localStorage.getItem("access_token")}`
        return config
    },

    (error) => {
        //so Maybe get rid of localstorage if you failed to log in with it?
        //well there is still a possibility of failing with unauthorized right
        console.log("error before request")
        return Promise.reject(error)
    }
    
)



axios.interceptors.response.use((response)=>{return response}, async (error) => 
    {
        let refresh = false

        const originalRequest = error.config

        if (error.response.status === 401 && !refresh){
            refresh = true
            const {status,data} = await axios.post('refreshtoken', {}, {withCredentials: true})

            if (status === 200){
                localStorage.setItem("access_token", data.access_token)
                originalRequest.headers['Authorization'] = `Bearer ${data.access_token}`
                return axios(originalRequest)
            }
        }    
    refresh = false
    return error    
    }
    
)
