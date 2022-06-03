<template>
    <div class="block">
        <v-container>
            <h2 class="text-center">Cards</h2>
            <v-row>
                <v-col cols="4" v-for="item in items" :key="item.id">
                <v-card outlined
                class="mx-auto"
                >
                    <v-img
                    class="white--text align-end"
                    height="200px"
                    :src="item.src"
                    >
                    <v-card-title>{{item.title}}</v-card-title>
                    </v-img>

                    <v-card-subtitle class="pb-0">
                    {{item.subtitle}}
                    </v-card-subtitle>

                    <v-card-text class="text--primary">
                    <div>{{item.description}}</div>
                    </v-card-text>

                    <v-card-actions>
                        <v-btn
                            color="primary"
                            text
                        >
                            More
                        </v-btn>
                    </v-card-actions>
                </v-card>
                </v-col>
            </v-row>
        </v-container>
    </div>
</template>

<script>
export default {
    name: "TheCards",

    data() {
        return {
            items: [
                {
                id: 1,
                src: 'https://cdn.vuetifyjs.com/images/cards/docks.jpg',
                title: 'Top 10 Australian beaches',
                subtitle: "Number 10",
                description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Amet consectetur adipiscing elit pellentesque."
                },
                {
                color: '#1F7087',
                id: 2,
                src: 'https://cdn.vuetifyjs.com/images/cards/foster.jpg',
                title: 'Supermodel',
                subtitle: "Foster the People",
                description: "Nec nam aliquam sem et tortor consequat id porta nibh. Tincidunt dui ut ornare lectus sit amet est placerat. Dolor magna eget est lorem ipsum.",
                },
                {
                color: '#952175',
                id: 3,
                src: 'https://cdn.vuetifyjs.com/images/cards/halcyon.png',
                title: 'Halcyon Days',
                subtitle: "Ellie Goulding",
                description: "Vel orci porta non pulvinar neque laoreet. Quis eleifend quam adipiscing vitae proin sagittis nisl rhoncus mattis. Duis ut diam quam nulla porttitor massa. Id eu nisl."
                },
            ],
        }
    }
}
</script>

<style scoped src="../assets/css/blocks.css">
</style>