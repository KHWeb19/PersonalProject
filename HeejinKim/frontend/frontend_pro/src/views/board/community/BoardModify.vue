<template>
    <v-container>
        <v-row>
            <board-motify-form v-if="board" :board="board" @submit="onSubmit"/>
        </v-row>
    </v-container>
</template>

<script>
import axios from 'axios'

import { mapActions, mapState } from 'vuex'
import BoardMotifyForm from '../../../components/board/community/BoardMotifyForm.vue'
export default {
  components: { BoardMotifyForm },

    name:'BoardModify',


    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    
    computed: {
        ...mapState(['board'])
    },

    methods: {
        ...mapActions(['fetchBoard']),

        onSubmit (payload) {
            const { title, content,writer, file, fileName} = payload

            let formData = new FormData()

            if (file != null ){formData.append('file', file)}
            formData.append('title',title)
            formData.append('content', content)
            formData.append('writer', writer)
            formData.append('fileName', fileName)
           
            
            console.log(formData)
            axios.put(`http://localhost:7777/board/community/${this.boardNo}`, formData, { headers: {
                    'Content-Type': 'multipart/form-data'
                }})
                    .then(res => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'BoardRead',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        }
    },
    created() {
        this.fetchBoard(this.boardNo)
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