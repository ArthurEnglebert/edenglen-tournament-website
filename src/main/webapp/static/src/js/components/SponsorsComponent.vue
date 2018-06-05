<template>
    <slick ref="slick" :options="slickOptions" :class="{footer__slider: true}">
        <div v-for="(slide, index) in slides" :class="{footer__slide: true}">
           <img :src="slide" :alt="'sponsor-' + (index + 1)"/>
        </div>
    </slick>
</template>

<script>
    import Slick from 'vue-slick';

    export default {
        components: { Slick },

        data() {
            return {
                slickOptions: {
                    slidesToShow: 4,
                    dots: false,
                    arrows: false,
                    autoplay: true,
                    autoplaySpeed: 1000,
                    speed: 1000
                },
                slides: [
                    'http://placehold.it/100x100',
                    'http://placehold.it/100x100',
                    'http://placehold.it/100x100',
                    'http://placehold.it/100x100',
                    'http://placehold.it/100x100',
                    'http://placehold.it/100x100',
                    'http://placehold.it/100x100',
                    'http://placehold.it/100x100',
                    'http://placehold.it/100x100',
                    'http://placehold.it/100x100',
                ]
            };
        },

        created() {

        },

        watch: {
            slides: function (newSlides) {
                let currIndex = this.$refs.slick.currentSlide()

                this.$refs.slick.destroy()

                this.$nextTick(() => {
                    this.$refs.slick.create()
                    this.$refs.slick.goTo(currIndex, true)
                })
            }
        },
    }
</script>