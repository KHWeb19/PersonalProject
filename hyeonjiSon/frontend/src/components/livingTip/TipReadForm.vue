<template>
    <div>

            <v-container>
                <v-card style="width: 54%" height="500px">
                    <v-toolbar style="background-color: #193821; color: #d5e0d8" dark>
                    <v-toolbar-title>{{ tipBoard.title }}</v-toolbar-title>
                            <v-spacer></v-spacer>
                            <v-btn id="likeBtn" @click="like" style="box-shadow:none"> 
                                <v-icon color="#ccbce3"> mdi-cards-heart </v-icon>
                            </v-btn>
                            <span> {{ tipBoard.likeCnt }} </span>
                    </v-toolbar>
                    <v-card-text style="font-size: 15px;">
                        {{ tipBoard.content}}
                    </v-card-text>


                        <v-card-text class="card-text-id caption" style="color: darkKhaki">
                            <v-divider style="margin-bottom:10px"></v-divider>
                            {{ tipBoard.writer.substr(0,6) }}
                        </v-card-text>
                        <v-card-text class="card-text-date caption">
                            {{new Date(tipBoard.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(0, 11)}}
                        </v-card-text>
                </v-card>
            </v-container>


        <br>

    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'TipReadForm',
    props: {
        tipBoard: {
            type: Object,
            required: true
        }
    },
    created() {
        this.boardNo = this.tipBoard.boardNo
        this.who = this.$store.state.userInfo.id
    },
    methods: {
        like () {
            const { boardNo, who } = this
            console.log(boardNo, who)
            if (this.iLike == true ){
                alert("이미 좋아요 하셨습니다 !")
            } else {
            axios.post(`http://localhost:7777/tipboard/${boardNo}/like`, {who})
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
        }
    }
}
</script>

<style scoped>
.tipTitle {
      font-size: 12px;
}
.card-text-id {
  position: absolute;
  bottom: 0;
  text-align: left;
}
.card-text-date {
  position: absolute;
  bottom: 0;
  text-align: right;
}
#likeBtn{
    background-color: transparent !important;
    background-image: none !important;
    box-shadow: none;
  }
</style>