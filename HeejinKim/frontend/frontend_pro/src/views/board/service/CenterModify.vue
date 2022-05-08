<template>
    <v-container>
        <v-row>
            <center-motify-form v-if="center" :center="center" @submit="onSubmit"/>
        </v-row>
    </v-container>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import CenterMotifyForm from '../../../components/board/service/CenterMotifyForm.vue'
export default {
  components: { CenterMotifyForm },
    name:'CenterMotify',
    props: {
        centerNo: {
            type: String,
            required: true
        }
    },
    
    computed: {
        ...mapState(['center'])
    },
    methods: {
        ...mapActions(['fetchCenter']),
        onSubmit (payload) {
            const { title, content,writer, file, fileName} = payload
            let formData = new FormData()
            if (file != null ){formData.append('file', file)}
            formData.append('title',title)
            formData.append('content', content)
            formData.append('writer', writer)
            formData.append('fileName', fileName)
           
            
            console.log(formData)
            axios.put(`http://localhost:7777/board/center/${this.centerNo}`, formData, { headers: {
                    'Content-Type': 'multipart/form-data'
                }})
                    .then(res => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'CenterRead',
                            params: { centerNo: res.data.centerNo.toString() }
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        }
    },
    created() {
        this.fetchCenter(this.centerNo)
        .catch(() => {
            alert('게시물 DB조회 실패!')
        })
    }
}
</script>

<style scoped>
.title{
    margin-top:5%;
    margin-bottom: 5%;
}
@media (max-width:700px){
    .title {
        margin-top:10%;
        margin-left:20px;
        margin-bottom:10%;
        width:200px;
    }
}
</style>