<template>
    <div>
        <h2 class="bar"></h2>
         <!-- 리스트로 돌아가기 -->
        <router-link :to="{ name: `${this.listPage}` }">
            <v-btn class="list-btn" color="amber lighten-2">
            <strong class="text">사진게시판</strong>
            </v-btn>
        </router-link>

        <div class="title">
            <h3> {{ board.title }} </h3>
            <div class="subtitle">
                <p align="center" class="writer">{{ board.writer }}</p>
                <div class="day"> 
                {{ board.regDate.substring(0, 10) }}
                {{ board.regDate.substring(19, 11) }}
                </div>
            </div>
        </div>

        <div>
            <v-img class="img" :src="require(`@/assets/uploadImg/${board.fileName}`)" ></v-img>
            <table>
                <tr>
                    <td>
                    <div> {{ board.content }}</div>
                    </td>
                </tr>
            </table>
        </div>

           <div class = "button">
            <!-- 수정 버튼 -->
            <router-link v-if="$store.state.userInfo.nickname == board.writer" 
                         :to="{ name: `${this.modifyPage}`, params: { boardNo } }">
                <v-btn class="modify-btn"
                       color="amber lighten-2">
                  <strong>수정</strong>
                </v-btn>
            </router-link>
            <!-- 삭제 버튼-->
            <v-btn v-if="$store.state.userInfo.nickname == board.writer" 
                   @click="onDelete"
                   class="remove-btn">
                <strong>삭제</strong>
            </v-btn>
            
        </div>
    </div>
</template>

<script>
import axios from 'axios'



export default {
    name: 'PhotoBoardRead',
    props: {
        board: {
            type: Object,
            required: true
        },
        boardNo: {
            type: String,
            required: true
        },
        listPage: {
            type: String
        },
        modifyPage:{
            type: String
        }
    },
    methods: {
           onDelete () {
            const boardNo= this.boardNo
            axios.delete(`http://localhost:7777/photoBoard/${boardNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'PhotoBoardListPage' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        }
    }
}
</script>

<style scoped>

.title{
    margin-left: 30%; 
    padding:15px;
    color:black;
    width:500px
}

.subtitle{
    margin-top: 10px;
}

.img {
    width: auto; 
    height: auto;
    max-width: 600px;
    max-height: 600px;
    margin-left: 30%;
    margin-bottom: 20px;
}
table {
    margin-left: 30%; 
    height: 200px;
    width: 600px;
    border: 1px solid transparent;
}
td {    
    border-bottom: 1px solid black;
    padding: 10px;
    color: black;
}
.writer{
    background-color:#EEEEEE;
    width:120px;
    font-size: 20px;
}
.day{
    border-bottom:1px solid #EEEEEE;
    width:600px;
    font-size: 17px;
    color: black;   
}
h3{
    font-size: 40px;
    
}
.modify-btn{
    margin-right: 5px;
}
.remove-btn{
    color:grey;
}
.bar{
    height:80px;
    padding: 20px;   
    background-color:#FFD54F;
    margin-bottom:50px;    
}
.text{
     font-family: 'Nanum Brush Script', cursive;
     font-size:18px;
}
.button {
    padding: 5px;
    margin-left: 60%;
}
a{
    text-decoration: none;  
}
.list-btn{
    margin-top:20px;
    margin-left:30%;
}


  
</style>