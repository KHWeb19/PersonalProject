<template>
    <v-container>
                <table>
                    <v-row>
                        <v-text-field class="date" color="red darken-3" rounded readonly :value="review.regDate"/>
                    </v-row>
                    <v-divider/>
                     <v-row v-if="review.writer == this.$store.state.userInfo.name">
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
                                    <router-link :to="{name:'ReviewModifyPage', 
                                    params: { reviewNo: review.reviewNo.toString()}}" style="color:white">Modify
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
                                :value="review.brackets"
                                style="width:120px; zoom:1.1; cursor:default"
                                rounded
                                readonly
                                color="red darken-3"
                                ></v-text-field>
                            <v-text-field class="titleFloat"  rounded style="width:500px; zoom:1.1" color="red darken-3" readonly :value="review.title"/>
                        </v-col>
                    </v-row>
                     <v-row>
                        <v-col cols="1" class="label"> Writer</v-col>
                        <v-col>
                        <v-text-field filled rounded  style="width:150px" color="red darken-3" readonly :value="review.writer"/>
                        </v-col>
                    </v-row>
                    <v-row justify="center">
                        <v-col cols="12" class="label2" style="font-size:23pt">Content</v-col>
                        <img v-if="this.review.fileName1 !== null && this.review.fileName1 !== 'null'" class="imgArea" 
                        :src="require(`@/assets/back/review/${this.review.fileName1}`)"
                        >
                    </v-row>
                    <v-row justify="center">
                        <img v-if="this.review.fileName2 !== null && this.review.fileName2 !== 'null'" class="imgArea" 
                        :src="require(`@/assets/back/review/${this.review.fileName2}`)"
                        >
                    </v-row>
        
                    <v-row justify="center">
                         <img v-if="this.review.fileName3 !== null && this.review.fileName3 !== 'null'" class="imgArea" 
                        :src="require(`@/assets/back/review/${this.review.fileName3}`)"
                        >
                    </v-row>
                    <v-row justify="center">
                         <img v-if="this.review.fileName4 !== null && this.review.fileName4 !== 'null'" class="imgArea" 
                        :src="require(`@/assets/back/review/${this.review.fileName4}`)"
                        >
                    </v-row>
                    <v-row justify="center">
                         <img v-if="this.review.fileName5 !== null && this.review.fileName5 !== 'null'" class="imgArea" 
                        :src="require(`@/assets/back/review/${this.review.fileName5}`)"
                        >
                    </v-row>
                    <v-row justify="center">
                        <v-col cols="12" >
                            <textarea style="white-space:pre-line" cols="80" rows="10"
                            outlined color="red darken-3" readonly class="txt" 
                            :value="review.content">
                            </textarea>
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
                            {{ review.likeCnt }}
                            </div>

                    </v-row>
                </table>
    </v-container>
</template>

<script>
import axios from 'axios'
import { mapActions } from 'vuex'

export default {

    name:'ReviewReading',
    props: {
        review: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
        fileName1: this.review.fileName1,
        }
    },
    created () {
        this.who = this.$store.state.userInfo.id
    },
    methods: {
        ...mapActions(['fetchReviewCommentsList']),
        goPage () {
            this.$router.push('/review')
        },
        onDelete () {
            const { reviewNo, fileName1, fileName2, fileName3, fileName4, fileName5 } = this.review
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/board/review/${reviewNo}`, {fileName1,  fileName2, fileName3, fileName4, fileName5})
                    .then(() => {
                        alert('게시글이 삭제되었습니다.')
                        this.$router.push({ name: 'ReviewPage' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        },
        like () {
            const { who } = this
            const { reviewNo } = this.review
            console.log(reviewNo, who)
            if (this.iLike == true ){
                alert("이미 좋아요 하셨습니다 !")
            } else {
            axios.post(`http://localhost:7777/board/review/${reviewNo}/like`, {who})
                 .then((res) => {
                    if (res.data == false) {
                    alert("이미 좋아요 하셨습니다!")
                } else {
                    alert("좋아요")
                    history.go(0)
                }
            })
            .catch(() => {
                alert ('좋아요 실패 문제발생 !')
            })
            }
        },
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
    padding-left: 11%;
    padding-right: 11%;
    padding-top: 2%;
    padding-bottom: 7%;
    margin-left:auto;
    margin-right:auto;
}
.v-combobox, .v-text-field{
    font-family: 'Noto Sans KR', sans-serif;
}
.txt {
    position: relative;
    text-align: center;
     font-family: 'Noto Sans KR', sans-serif;
    padding-top :5%;
    overflow: visible;
    outline-color: rgb(197, 30, 30);
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
    top:120px;
}
a{
    text-emphasis: none;
  color:white;
}
.imgArea {
    position: relative;
    max-height: 500px;
    max-width: 600px;
    margin-top: 4%;
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