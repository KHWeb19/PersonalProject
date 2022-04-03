<template>
    <div align="center">
        <h2> Modify My Info </h2>
        <member-modify-form @submit="onSubmit"/>

    </div>

</template>

<script>
import MemberModifyForm from "@/components/form/MemberModifyForm.vue"

export default 
  {
    name: 'MemberModifyPage',
    components: { MemberModifyForm },
    props: {
        memberNo: {
            type: String,
            required: true
        }
    },
}
</script>