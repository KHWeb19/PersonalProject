<template>
<div align="center">
    <v-container>
    <form @submit.prevent="onSubmit">
        <table>
            <tr>
                <td class="guide">제목</td>
            </tr>
            <tr>
                <td>
                    <textarea
                        style="height: 25px"
                        id="content" type="text" v-model="title" placeholder=" *필수 입력">
                    </textarea>
                </td>
            </tr>
            <tr>
                <td class="guide">본문</td>
            </tr>
            <tr>

                <td>
                    <textarea cols="50" rows="20" v-model="content" placeholder=" *내용을 작성해주세요.">
                    </textarea>
                </td>
            </tr>
        </table>

        <div style="width: 500px; margin: 30px;">
            <v-row>
                <router-link :to="{ name: 'livingTipBoardList' }">
                    <v-btn id="btn">
                        돌아가기
                    </v-btn>
                </router-link>
                <v-spacer></v-spacer>            
                <v-btn type="submit" id="btn">등록</v-btn>
            </v-row>
        </div>
    </form>
    </v-container>
</div>
</template>

<script>
export default {
    name: 'TipRegisterForm.vue',
    data () {
        return {
            userInfo: JSON.parse(localStorage.getItem('userInfo')),
            title: '',
            writer: this.$store.state.userInfo.sn,
            content: '',
        }
    },
    created () {
        this.writer = this.$store.state.userInfo.sn
    },    
    methods: {
        onSubmit () {
            console.log(this.$store.state.userInfo.sn)
            const { title, writer, content } = this
            this.$emit('submit', { title, writer, content })
        }
    }
    
}
</script>


<style scoped>
.guide{
    font-weight: bold;
    color: #907bb0;
}

table {
    border: collapse;
    border-radius: 10px;
    width: 500px;
}
tr {
    height: 30px;
}
textarea {
    width: 100%;
    margin: 0px;
    outline-color: #ccbce3;
    resize: none; /* 크기 조절 없앰 */
}
/*th, td {
    border-bottom: 1px solid #444444;
    margin: 0px;
    padding: 10px;
  } */
td{
    vertical-align: top;
}
a {
    text-decoration: none;
    } 

#btn{
    color: white;
    background-color: darkkhaki;
    width: 100px;
    box-shadow: none;  
}
</style>