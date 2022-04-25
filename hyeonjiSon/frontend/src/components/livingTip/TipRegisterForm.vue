<template>
<div align="center">
    <v-container>
    <form @submit.prevent="onSubmit">
        <table>
            <tr>
                <td class="guide">제목</td>
                <td>
                    <input type="text" v-model="title" placeholder=" *필수 입력"/>
                </td>
            </tr>
            <tr>
                <td class="guide">본문</td>
                <td>
                    <textarea cols="50" rows="20" v-model="content" placeholder=" *내용을 작성해주세요.">
                    </textarea>
                </td>
            </tr>
        </table>

        <div>
            <v-btn type="submit">등록</v-btn>
            <router-link :to="{ name: 'livingTipBoardList' }">
                <v-btn>
                    취소
                </v-btn>
            </router-link>
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
            title: '',
            writer: this.$store.state.userInfo.storeName,
            content: '',
        }
    },
    created () {
        this.writer = this.$store.state.userInfo.storeName
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
.guide{
    font-weight: bold;
}
table {
    border: collapse;
    border-radius: 10px;
}
tr {
    height: 50px;
}
input {
    height: 35px;
    margin: 0px;
}
th, td {
    border-bottom: 1px solid #444444;
    margin: 0px;
    padding: 10px;
  }
td{
    
    vertical-align: top;
}
</style>