<template>
     <form @submit.prevent="onSubmit">
         <v-row justify="center" style="margin:2%;">
            <h4 style="margin-top:1%;"><strong>공지사항</strong></h4>
        </v-row>

        <div class="board-box">
            <v-col cols="12" md="12" >
                <v-text-field label="제목" required height="5vh" style="margin-top:10px;" 
                    v-model="title" :rules="[v => !!v || '제목을 입력하세요.']" type="title">
                </v-text-field>

                <v-text-field label="작성자" required height="5vh" style="margin-top:10px;" 
                    v-model="writer" :rules="[v => !!v || '필수정보입니다.']" type="writer">
                </v-text-field>

                <v-textarea label="본문"  auto-grow style="margin-top:10px;" counter maxlength="500"
                    full-width single-line outlined
                    v-model="content" :rules="[v => !!v || '본문을 입력하세요.']" type="content">
                </v-textarea>
            </v-col>

            <div class="btn-size">
                <v-col cols="12" md="12"> 
                    <v-btn plain class="basil--text" type="submit" depressed>등록</v-btn>
                    <v-btn plain class="basil--text" depressed router :to="{ name: 'NoticeListPage' }">
                        취소
                    </v-btn>
                </v-col>
            </div>
        </div>
    </form>
</template>

<script>

import { mapState } from 'vuex'

export default {
    name: 'NoticeRegisterForm',
    data () {
        return {
            title: '',
            writer: '관리자',
            content: ''
        }
    },
    computed: {
        ...mapState([ 'userInfo', 'isLogin' ])
    },
    methods: {
        onSubmit () {
            const { title, writer, content } = this
            this.$emit('submit', { title, writer, content })
        }
    }
}
</script>

<style scoped>

.reserve{
    position: relative;
    height: 800px;
    width: 1200px;
}
.board-box {
    text-align: center;
    width: 50%;
    margin: 0 auto;
}
/* .register-box{
    border: 1px solid #cccccc;
    background-color: white;
    float: left;
    width: 500px;
    height: 500px;
}
.btn-size{
    margin: 0 auto;
    text-align: center;
    width: 50%;
    padding: 3% 0% 5% 0%;
} */
h4 {
    margin-top: 0px;
    font-size: 30px;
    text-align: center;
}
.member-box {
    margin-top: 2%;
}
</style>