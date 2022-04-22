<template>
    <v-container>
        <table>
            <v-row justify="center">
                <v-col cols="1" class="label">Title</v-col>
                <v-col>
                    <v-text-field rounded style="width:300px" readonly :value="board.title"/>
                </v-col>
            </v-row>

            <v-row>
                <v-col cols="1" class="label"> Writer</v-col>
                <v-col>
                    <v-text-field rounded style="width:150px" readonly :value="board.writer"/>
                </v-col>
            </v-row>

            <v-row>
                <v-col cols="1" class="label"> Date</v-col>
                <v-col>
                    <v-text-field class="date" rounded readonly :value="board.regDate"/>
                </v-col>
            </v-row>

            <v-row>
                <v-col cols="12">
                    <v-textarea cols="80" rows="20" outlined color="grey"
                    style="white-space:pre-line"  class="mt-3" readonly
                    :value="board.content">
                    </v-textarea>
                </v-col>
            </v-row>

            <v-row justify="center">
                <img v-if="this.board.fileName !== null && this.board.fileName !== 'null'" class="addImg" 
                :src="require(`@/assets/uploadImg/${this.board.fileName}`)">
            </v-row>
            
            <v-row>
                <v-btn @click="backPage" class="backBtn" dark> Back</v-btn>
            </v-row>

            <v-row v-if="board.writer == this.userId">  
    
                <router-link :to="{name:'BoardModify', params:{boardNo: board.boardNo.toString()}}" style="text-decoration:none">
                    <v-btn class="modifyBtn">Modify</v-btn>
                </router-link>
        
                <v-btn @click=onDelete dark>Delete</v-btn>

            </v-row>

        </table>
    </v-container>
</template>

<script>
import axios from 'axios'
import { mapActions } from 'vuex'
export default {
    name:'BoardReadForm',
    
    props: {
        board: {
            type: Object,
            required: true
        }
    },

    data () {
        return {

        fileName: this.board.fileName,
        

        }
    },
    created () {
        this.boardNo = this.board.boardNo
        this.userId = this.$store.state.session.userId
    },
    methods: {
        ...mapActions(['fetchBoardList','fetchCommentsList']),
        backPage () {
            this.$router.push('/communityBoard')
        },
        onDelete () {
            const { boardNo, fileName } = this.board
            
            axios.delete(`http://localhost:7777/board/community/${boardNo}`, {fileName})
                    .then(() => {
                        alert('게시글 삭제')
                        this.$router.push({ name: 'BoardList' })
                    })
                    .catch(() => {
                        alert('삭제 실패')
                    })
        },
    }
}
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Poiret+One&family=Sunflower:wght@300&family=Ubuntu:wght@300&display=swap");

.label{

    font-family: 'Ubuntu', sans-serif; 
    font-size: 17pt;
    margin-right:5%;
    text-align: center;
    padding-top: 25px; 
}

table{
    background-color: #f3f3f3;
    padding: 5% 10% 5% 10%;
    margin-left:auto;
    margin-right:auto;
}
.modifyBtn{
    color:rgba(214, 86, 103, 0.596);  
}
.v-text-field, .v-textarea{
    font-family: 'Sunflower', sans-serif;
}
.addImg {
    position: relative;
    max-height: 400px;
    max-width: 500px;
}

</style>
    