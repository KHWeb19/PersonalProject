<template>
    <div>
        <div align="center">
            <notice-register-form @submit="onSubmit"/>
        </div>
    </div>
</template>

<script>

import NoticeRegisterForm from '@/components/notice/NoticeRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'NoticeRegisterPage',
    components: {
        NoticeRegisterForm,
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer } = payload
            axios.post('http://localhost:7777/notice/register', { title, writer, content })
                    .then(() => {
                        alert('게시물 등록 성공!')

                        this.$router.push({
                            name: 'NoticeListPage'
                        })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    }
}

</script>