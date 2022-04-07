<template>
    <div>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>생일관리 수정하기</td>
                    <td>
                        <input type="text" :value="jpaBoard3.boardNo" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td>
                        <input type="text" v-model="title"/>
                    </td>
                </tr>
                <tr>
                    <td>생년월일</td>
                    <td>
                        <input type="text" :value="jpaBoard3.writer"/>
                    </td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td>
                        <input type="text" :value="jpaBoard3.regDate" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>본문</td>
                    <td>
                        <textarea cols="50" rows="20" v-model="content">
                        </textarea>
                    </td>
                </tr>
            </table>

            <div>
                <button type="submit">수정 완료</button>
                <router-link :to="{ name: 'JpaBoardReadPage3',
                                    params: { boardNo: jpaBoard3.boardNo.toString() } }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: 'JpaBoardModifyForm3',
    props: {
        jpaBoard3: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            title: '',
            writer:'',
            content: ''
        }
    },
    methods: {
        onSubmit () {
            const { title, content, writer } = this
            this.$emit('submit', { title, content, writer })
        }
    },
    created () {
        this.title = this.jpaBoard3.title
        this.content = this.jpaBoard3.content
        this.writer = this.jpaBoard3.writer
    }
}
</script>