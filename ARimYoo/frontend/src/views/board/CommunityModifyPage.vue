<template>
    <v-container>
        <v-row justify="center">
            <img class="title" src="@/assets/title/communityTitle.png" width=250 >
        </v-row>
        <v-row>
            <community-modify :communityBoard="communityBoard" @submit="onSubmit"/>
        </v-row>
    </v-container>
</template>

<script>
import axios from 'axios'
import CommunityModify from '@/components/board/community/CommunityBoardModify.vue'
import { mapActions, mapState } from 'vuex'

export default {
  components: { CommunityModify },
    name:'CommunityModifyPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['communityBoard'])
    },
    methods: {
        ...mapActions(['fetchCommunityBoard']),
        onSubmit (payload) {
            const { title, content, brackets,writer, file, fileName, viewCnt} = payload
              let formData = new FormData()

            if (file != null ){formData.append('file', file)}
            formData.append('title',title)
            formData.append('content', content)
            formData.append('writer', writer)
            formData.append('brackets', brackets)
            formData.append('fileName', fileName)
            formData.append('viewCnt', viewCnt)

            console.log(formData)

            axios.put(`http://localhost:7777/board/community/${this.boardNo}`, formData, { headers: {
                    'Content-Type': 'multipart/form-data'
                }})
                    .then(res => {
                        alert('게시물 수정 성공!')
                        this.$router.push({
                            name: 'CommunityReadPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                    .catch(() => {
                        alert('게시물 수정 실패!')
                    })
        }
    },
    created() {
        this.fetchCommunityBoard(this.boardNo)
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