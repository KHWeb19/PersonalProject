<style>
            table2{
            width: 75%;
            color:whitesmoke;
            text-align :center;
            }
            table2 th{
                padding : 12px;
            }
            table2 td{
                text-align: center;
                vertical-align: middle;
                padding : 12px;
                border: 1px solid rgb(57, 57, 57);
                background-color: rgb(30, 30, 30);

            }
            table2 tr:nth-of-type(even){
                background-color: rgba(0,0,255,0.1);
            }
</style>
<template>
    <form @submit.prevent="onSubmit">
        <table2 border="1" >
            <tr>
                <td>제목</td>
                <td>
                    <input type="text" style="width:410px; color:white" v-model="title"/>
                </td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>
                    <input type="text" style="width:410px; color:white" :value="this.$store.state.userInfo.nickname" disabled>
                </td>
            </tr>
            <tr>
                <td>본문</td>
                <td>
                    <textarea cols="50" rows="15" v-model="content" style="color:white">
                    </textarea>
                </td>
            </tr>
        </table2>
        <div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <v-btn type="submit" tile color="grey darken-2 white--text" width="100" :style="{fontSize:'medium'}"><v-icon> mdi-send</v-icon>
            등록</v-btn>
             <v-btn type="button" tile color="grey darken-4 white--text" width="100" :style="{fontSize:'medium'}" onclick="location.href='http://localhost:8080/stock'"><v-icon>mdi-close-circle-outline</v-icon>
            취소</v-btn>
        </div>
    </form>
</template>

<script>
import { mapState } from 'vuex'

export default {
    name: 'ForeignBoardRegisterForm',
    data () {
        return {
            title: '제목을 작성하세요.',
            writer: this.$store.state.userInfo.nickname,
            content: '본문을 작성하세요.'
        }
    },
    methods: {
        onSubmit () {
            const { title, writer, content } = this
            this.$emit('submit', { title, writer, content })
        }
    },
    computed: {
        ...mapState(['userInfo'])
    },

}
</script>