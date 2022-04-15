<template>
    <v-container>
                <table>
                    <v-row>
                        <v-text-field class="date" color="red darken-3" rounded readonly :value="communityBoard.regDate"/>
                    </v-row>
                    <v-divider/>
                     <v-row v-if="communityBoard.writer == this.$store.state.userInfo.name">
                        <v-menu offset-y bottom>
                            <template v-slot:activator="{ attrs, on }">
                                <v-btn
                                class="extraBtn"
                                color="red darken-3"
                                dark
                                fab
                                v-bind="attrs"
                                v-on="on"
                                >
                                <v-icon> mdi-dots-horizontal </v-icon>
                                </v-btn>
                            </template>
                            <v-list class="black" dark>
                                <v-list-item>
                                    <router-link :to="{name:'CommunityModifyPage', 
                                    params: { boardNo: communityBoard.boardNo.toString()}}" style="color:white">Modify
                                    </router-link>
                                </v-list-item>
                                <v-list-item>
                                    <a @click=onDelete  style="color:white">Delete</a>
                                </v-list-item>
                            </v-list>
                    </v-menu>
                  </v-row>
                    <br/>
                    <v-row justify="center">
                        <v-col cols="1" class="label">Title</v-col>
                        <v-col>
                            <v-text-field
                                class="titleFloat"
                                :value="communityBoard.brackets"
                                style="width:100px; zoom:1.1; cursor:default"
                                rounded
                                readonly
                                color="red darken-3"
                                ></v-text-field>
                            <v-text-field class="titleFloat"  rounded style="width:500px; zoom:1.1" color="red darken-3" readonly :value="communityBoard.title"/>
                        </v-col>
                    </v-row>
                     <v-row>
                        <v-col cols="1" class="label"> Writer</v-col>
                        <v-col>
                        <v-text-field filled rounded  style="width:150px" color="red darken-3" readonly :value="communityBoard.writer"/>
                        </v-col>
                    </v-row>
                    <v-row justify="center">
                        <v-col cols="12" class="label2" style="font-size:23pt">Content</v-col>
                        <img v-if="this.communityBoard.fileName !== null && this.communityBoard.fileName !== 'null'" class="imgArea" 
                        :src="require(`@/assets/back/${this.communityBoard.fileName}`)"
                        >
                    </v-row>
                    <v-row>
                        <v-col cols="12">
                            <v-textarea style="white-space:pre-line" cols="75" 
                            outlined color="red darken-3" readonly
                            :value="communityBoard.content">
                            </v-textarea>
                        </v-col>
                    </v-row>
                    <v-row wrap>
                        <v-col cols="10.5">
                            <v-btn @click=goPage() class="backBtn" color="black" dark>Back</v-btn>
                        </v-col>
                        <v-col cols="1">
                            <v-btn @click=like color="yellow darken-1" style="box-shadow:none" dark fab small>
                                <v-icon>mdi-cards-heart</v-icon>
                            </v-btn>
                        </v-col>
                                <div class="likeCnt">
                            {{ communityBoard.likeCnt }}
                            </div>

                    </v-row>
                </table>
    </v-container>
</template>

<script>
import axios from 'axios'
import { mapActions } from 'vuex'

export default {

    name:'CommunityBoardRead',
    props: {
        communityBoard: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
        fileName: this.communityBoard.fileName,
        }
    },
    created () {
        this.boardNo = this.communityBoard.boardNo
        this.who = this.$store.state.userInfo.id
    },
    methods: {
        ...mapActions(['fetchCommunityCommentsList']),
        goPage () {
            this.$router.push('/community')
        },
        onDelete () {
            const { boardNo, fileName } = this.communityBoard
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/board/community/${boardNo}`, {fileName})
                    .then(() => {
                        alert('게시글이 삭제되었습니다.')
                        this.$router.push({ name: 'CommunityPage' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        },
        like () {
            const { boardNo, who } = this
            console.log(boardNo, who)
            if (this.iLike == true ){
                alert("이미 좋아요 하셨습니다 !")
            } else {
            axios.post(`http://localhost:7777/board/community/${boardNo}/like`, {who})
                 .then((res) => {
                    if (res.data == false) {
                    alert("이미 좋아요 하셨습니다!")
                } else {
                    alert("좋아요")
                }
            })
            .catch(() => {
                alert ('좋아요 실패 문제발생 !')
            })
            }
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap');
.label{
    margin-right:3%;
    text-align: center;
    padding-top: 30px;
    font-family: 'Noto Sans KR', sans-serif;
    font-size:15pt;
}
.label2{
     font-family: 'Noto Sans KR', sans-serif;
     text-align: center;

}
table{
    position: relative;
    background-color: rgb(245, 244, 244);
    padding-left: 12%;
    padding-right: 12%;
    padding-top: 2%;
    padding-bottom: 7%;
    margin-left:auto;
    margin-right:auto;
}
.v-combobox, .v-text-field, .v-textarea{
    font-family: 'Noto Sans KR', sans-serif;
}

.titleFloat {
    float:left;
    cursor: default;
}
.date {
    position: relative;
    left:70%;
}
.backBtn {
    zoom:1.2;
}
.extraBtn {
    position: absolute;
    left:80%;
    top:15%;
}
a{
    text-emphasis: none;
  color:white;
}
.imgArea {
    position: relative;
    max-height: 500px;
    max-width: 600px;
}
.likeCnt {
     font-family: 'Noto Sans KR', sans-serif;
     
}
@media (max-width:700px){
    table {
        top:4%;
        margin-left:10px;
        zoom:60%;
        margin-bottom:50px;
    }
    .date {
        left:60%;
    }
    .label {
        margin-right:40px;
    }
}
</style>